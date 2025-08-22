<script setup>
import { ref } from 'vue'
import { useTodoStore } from '@/stores/todoStore'
import { storeToRefs } from 'pinia'
import { useRouter } from 'vue-router'

import TodoItem from '@/components/todos/TodoItem.vue'
import EditTodoModal from '@/components/todos/EditTodoModal.vue'

const router = useRouter()
const todoStore = useTodoStore()
const { todoList } = storeToRefs(todoStore)

// Modal state
const showEditModal = ref(false)
const editingTodo = ref(null)

function handleEditTodo(todoItem) {
  editingTodo.value = todoItem
  showEditModal.value = true
}

function handleSaveEdit({ title, content }) {
  if (editingTodo.value) {
    editingTodo.value.todoName = title
    editingTodo.value.todoContent = content
    showEditModal.value = false
    editingTodo.value = null
  }
}

function confirmClear() {
  if (confirm('Are you sure you want to delete all todos? This cannot be undone.')) {
    clearTodos()
  }
}

function clearTodos() {
  todoStore.clearStoredTodo()
}

function addItem() {
  router.push('/edit')
}
</script>

<template>
  <div class="p-3">
    <div class="row g-2">
      <div
        v-for="todo in todoList"
        :key="todo.id"
        class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2"
      >
        <TodoItem :todo-item="todo" @edit-todo="handleEditTodo" />
      </div>
    </div>
    <button
      class="mt-2 btn btn-secondary rounded-circle d-flex align-items-center justify-content-center shadow-sm"
      style="width: 60px; aspect-ratio: 1 / 1"
      @click="addItem"
    >
      <i class="bi bi-plus fs-3"></i>
    </button>
  </div>

  <button
    class="btn btn-danger position-fixed bottom-0 end-0 m-4 rounded-circle d-flex align-items-center justify-content-center"
    style="width: 60px; aspect-ratio: 1 / 1; z-index: 1050"
    @click="confirmClear"
  >
    <i class="bi bi-trash fs-4"></i>
  </button>

  <!-- Single modal for editing todos -->
  <EditTodoModal v-model:show="showEditModal" :todo-item="editingTodo" @save="handleSaveEdit" />
</template>
