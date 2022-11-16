import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/house',
    name: 'house',
    component: () => import(/* webpackChunkName: "about" */ '../views/HouseView.vue')
  },
  {
    path: '/map/test',
    name: 'mapTest',
    component: () => import(/* webpackChunkName: "about" */ '../views/MapTestView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
