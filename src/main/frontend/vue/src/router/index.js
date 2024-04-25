import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MessagesView from '../views/MessagesView.vue'
import MessagesById from '../views/MessageById.vue'

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
    //   path: '/findById',
    //   name: 'findById',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: MessagesById
    // }
    {
      path: '/findById/:id',
      name: 'findById',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/MessageById.vue')
    }
  ]
})

export default router
