import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

export const useAuthStore = defineStore('auth', () => {
  const isLoggedIn = ref(false)
  const userId = ref(-1)
  const username = ref('')
  const email = ref()
  const creationDate = ref()
  const roleName = ref('')
  const isActive = ref(false)
  const googleToken = ref(null)
  const isLoading = ref(false)

  const userInfo = computed(() => ({
    userId: userId.value,
    username: username.value,
    email: email.value,
    creationDate: creationDate.value,
    roleName: roleName.value,
    isActive: isActive.value,
  }))

  function setUser(user) {
    userId.value = user.userId || -1
    username.value = user.username || user.name || ''
    email.value = user.email
    creationDate.value = user.creationDate || new Date().toISOString()
    roleName.value = user.roleName || 'user'
    isActive.value = user.isActive !== undefined ? user.isActive : true
    isLoggedIn.value = true
  }

  function clearUser() {
    userId.value = -1
    username.value = ''
    email.value = undefined
    creationDate.value = undefined
    roleName.value = ''
    isActive.value = false
    isLoggedIn.value = false
    googleToken.value = null
  }

  function clearStoredAuth() {
    localStorage.removeItem('google_token')
    localStorage.removeItem('user_data')
  }

  function initAuth() {
    const token = localStorage.getItem('google_token')
    const userData = localStorage.getItem('user_data')

    if (token && userData) {
      try {
        const user = JSON.parse(userData)
        googleToken.value = token
        setUser(user)
      } catch (error) {
        console.error('Failed to parse stored user data:', error)
        clearStoredAuth()
      }
    }
  }

  function setGoogleAuth(user, accessToken) {
    setUser(user)
    googleToken.value = accessToken
    localStorage.setItem('google_token', accessToken)
    localStorage.setItem('user_data', JSON.stringify(user))
  }

  function logOut(router) {
    clearUser()
    clearStoredAuth()
    router.push('/login')
  }

  function setLoading(loading) {
    isLoading.value = loading
  }

  // mock login
  async function login(usernameInput, password) {
    if (usernameInput === 'thnrgbefv0987@gmail.com' && password === 'DefaultP4$$') {
      const user = {
        userId: 1,
        username: 'Nguyen Quoc Minh',
        email: usernameInput,
        creationDate: new Date().toISOString(),
        roleName: 'user',
        isActive: true,
      }
      setUser(user)
      localStorage.setItem('user_data', JSON.stringify(user))
      return
    }
    throw new Error('Invalid credentials')
  }

  // run init on store creation
  initAuth()

  return {
    isLoggedIn,
    userId,
    username,
    email,
    creationDate,
    roleName,
    isActive,
    googleToken,
    isLoading,
    userInfo,
    setUser,
    clearUser,
    logOut,
    initAuth,
    setGoogleAuth,
    setLoading,
    clearStoredAuth,
    login,
  }
})
