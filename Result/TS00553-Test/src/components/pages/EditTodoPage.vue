<script setup>
import { ref } from 'vue'
import { useTodoStore } from '@/stores/todoStore'
import { useRouter } from 'vue-router'

const todoStore = useTodoStore()
const router = useRouter()

const todoName = ref('')
const todoContent = ref('')

function handleSubmit() {
  todoStore.addTodo({
    todoName: todoName.value,
    todoContent: todoContent.value,
    creationDate: formatDate(new Date()),
    state: false,
  })

  todoName.value = ''
  todoContent.value = ''

  router.push('/')
}

function formatDate(date) {
  const d = new Date(date)
  const day = String(d.getDate()).padStart(2, '0')
  const month = String(d.getMonth() + 1).padStart(2, '0')
  const year = d.getFullYear()
  return `${day}-${month}-${year}`
}
</script>

<template>
  <div class="container p-4">
    <div class="card shadow-lg">
      <h2 class="text-center p-3">Thêm công việc</h2>
      <hr class="m-0 p-0" />
      <form @submit.prevent="handleSubmit" class="p-4">
        <div class="form-group">
          <label for="todo-name">Tên công việc</label>
          <input
            v-model="todoName"
            class="form-control my-2"
            id="todo-name"
            type="text"
            placeholder="Tên công việc"
          />
        </div>
        <div class="form-group">
          <label for="todo-content">Nội dung</label>
          <input
            v-model="todoContent"
            class="form-control my-2"
            id="todo-content"
            type="text"
            placeholder="Nội dung công việc"
          />
        </div>
        <button class="btn btn-primary">Lưu</button>
      </form>
    </div>
  </div>
</template>
