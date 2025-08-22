class GoogleAuthService {
  constructor() {
    this.clientId = '874874418034-82h11ndqeh59ent2dgdfi18bnq291bj2.apps.googleusercontent.com'
    this.redirectUri = window.location.origin + '/auth/callback'
    this.scopes = ['openid', 'email', 'profile']
  }

  // Generate Google OAuth2 login URL
  getAuthUrl(state = '') {
    const base = 'https://accounts.google.com/o/oauth2/v2/auth'
    const params = new URLSearchParams({
      client_id: this.clientId,
      redirect_uri: this.redirectUri,
      response_type: 'token',
      scope: this.scopes.join(' '),
      state,
    })
    return `${base}?${params.toString()}`
  }

  // Handle redirect back from Google (extract token + fetch userinfo)
  async handleRedirectCallback(authStore) {
    const hash = new URLSearchParams(window.location.hash.substring(1))
    const accessToken = hash.get('access_token')
    if (!accessToken) return false

    try {
      authStore.setLoading(true)
      const res = await fetch('https://www.googleapis.com/oauth2/v3/userinfo', {
        headers: { Authorization: `Bearer ${accessToken}` },
      })
      const userInfo = await res.json()

      const user = {
        userId: userInfo.sub,
        username: userInfo.name,
        email: userInfo.email,
        creationDate: new Date().toISOString(),
        roleName: 'user',
        isActive: true,
      }

      authStore.setGoogleAuth(user, accessToken)
      return true
    } catch (err) {
      console.error('Google callback failed:', err)
      return false
    } finally {
      authStore.setLoading(false)
    }
  }
}

export default new GoogleAuthService()
