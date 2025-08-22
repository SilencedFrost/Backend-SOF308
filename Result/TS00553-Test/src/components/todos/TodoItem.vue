<script setup>
import { toRefs } from 'vue'
import { useTodoStore } from '@/stores/todoStore'

const todoStore = useTodoStore()
const props = defineProps({ todoItem: Object })
const { id, todoName, todoContent, creationDate, state } = toRefs(props.todoItem)

const emit = defineEmits(['edit-todo'])

function openEditModal() {
  emit('edit-todo', props.todoItem)
}

function confirmClear(id, todoName) {
  if (confirm(`Are you sure you want to delete ${todoName}? This action cannot be undone`)) {
    todoStore.removeTodo(id)
  }
}
</script>

<template>
  <div class="card shadow bg-body">
    <div class="p-2">
      <div class="d-flex align-items-center">
        <input
          type="checkbox"
          v-model="state"
          class="form-check-input rounded-circle border-success custom-success-checkbox"
        />
        <h3 class="m-0 ms-1 p-0">{{ todoName }}</h3>
      </div>
      <small class="text-secondary">{{ creationDate }}</small>
    </div>
    <div class="card border-light-subtle shadow-sm mx-2 p-2" style="min-height: 5rem">
      {{ todoContent }}
    </div>
    <div class="d-flex mx-2 mb-2 gap-2 mt-2">
      <button class="btn btn-primary py-1 px-3 ms-auto" @click="openEditModal">Edit</button>
      <button class="btn btn-danger py-1 px-3" @click="confirmClear(id, todoName)">Delete</button>
    </div>
  </div>
</template>

<style scoped>
.custom-success-checkbox:checked {
  background-color: var(--bs-success);
  border-color: var(--bs-success);
}
</style>
