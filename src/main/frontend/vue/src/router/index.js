import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MessagesView from '../views/MessagesView.vue'
import MessageById from '../views/MessageById.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/messages',
      name: 'history',
      component: MessagesView
    },
    // {
    //   path: '/findById/:id',
    //   name: 'findById',
    //   component: MessageById
    // },
    {
      path: '/findById/:id',
      name: 'findById',
      component: () => import('../views/MessageById.vue')
    },
  ]
})
export default
  router

