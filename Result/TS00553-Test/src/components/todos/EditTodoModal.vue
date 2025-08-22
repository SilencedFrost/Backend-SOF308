<!-- @/components/todos/EditTodoModal.vue -->
<script setup>
import { ref, watch, computed } from 'vue'
import { BModal } from 'bootstrap-vue-3'

const props = defineProps({
  show: Boolean,
  todoItem: Object,
})

const emit = defineEmits(['update:show', 'save'])

const editTitle = ref('')
const editContent = ref('')

// Watch for prop changes to populate form
watch(
  () => props.todoItem,
  (newTodo) => {
    if (newTodo) {
      editTitle.value = newTodo.todoName
      editContent.value = newTodo.todoContent
    }
  },
  { immediate: true },
)

// Handle modal visibility with v-model
const showModal = computed({
  get: () => props.show,
  set: (value) => emit('update:show', value),
})

function saveEdit() {
  emit('save', {
    title: editTitle.value,
    content: editContent.value,
  })
}

function cancelEdit() {
  emit('update:show', false)
}
</script>

<template>
  <b-modal v-model="showModal" title="Edit Todo" hide-footer centered teleport>
    <div class="mb-3">
      <label class="form-label">Title</label>
      <input v-model="editTitle" type="text" class="form-control" />
    </div>
    <div class="mb-3">
      <label class="form-label">Content</label>
      <textarea v-model="editContent" class="form-control" rows="4"></textarea>
    </div>
    <div class="d-flex gap-2">
      <button type="button" class="ms-auto btn btn-secondary" @click="cancelEdit">Cancel</button>
      <button type="button" class="btn btn-success" @click="saveEdit">Save</button>
    </div>
  </b-modal>
</template>
