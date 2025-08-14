import { defineStore } from 'pinia';

export const useAuthStore = defineStore('auth', {
    state: () => ({
        user: null,
        isAuthenticated: false,
        mockUser: {
            username: 'admin01',
            password: '123'
        }
    }),
    actions: {
        login(username, password) {
            if (
                username === this.mockUser.username &&
                password === this.mockUser.password
            ) {
                this.user = { username };
                this.isAuthenticated = true;
                return true;
            }
            this.user = null;
            this.isAuthenticated = false;
            return false;
        },
        logout() {
            this.user = null;
            this.isAuthenticated = false;
        }
    },
    getters: {
        username: (state) => state.mockUser.username,
        password: (state) => state.mockUser.password,
        isValidated: (state) => state.isAuthenticated
    }
});