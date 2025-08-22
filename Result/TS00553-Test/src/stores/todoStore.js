import { defineStore } from 'pinia'
import { ref } from 'vue'
import { watch } from 'vue'

export const useTodoStore = defineStore('todo', () => {
  const todoList = ref([])

  function saveTodos() {
    localStorage.setItem('todoList', JSON.stringify(todoList.value))
  }

  function addTodo({ todoName, todoContent, creationDate, state }) {
    const newTodo = {
      id: crypto.randomUUID(),
      todoName,
      todoContent,
      creationDate,
      state,
    }
    todoList.value.push(newTodo)
    saveTodos()
  }

  function removeTodo(todoId) {
    todoList.value = todoList.value.filter((todo) => todo.id !== todoId)
    saveTodos()
  }

  function clearStoredTodo() {
    localStorage.removeItem('todoList')
    todoList.value = []
  }

  function initTodo() {
    const todoData = localStorage.getItem('todoList')
    if (todoData) {
      try {
        todoList.value = JSON.parse(todoData)
      } catch (error) {
        console.error('Failed to parse stored todo list:', error)
        clearStoredTodo()
      }
    }
  }

  initTodo()

  watch(todoList, saveTodos, { deep: true })

  return {
    todoList,
    addTodo,
    removeTodo,
    clearStoredTodo,
  }
})
