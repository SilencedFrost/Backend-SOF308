<script>
export default {
    data() {
        return {
            greeting: 'Lời chào ban đầu',
            buttonTitle: 'Hi'
        }
    },

    methods: {
        changeGreeting() {
            this.greeting = 'Lời chào đã được thay đổi'
        }
    }
}
</script>

<template>
    <h1>{{ greeting }}</h1>
    <button :title="buttonTitle" @click="changeGreeting()">Click để thay đổi</button>
</template>