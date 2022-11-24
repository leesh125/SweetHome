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
    component: () => import(/* webpackChunkName: "about" */ '../views/MapTestView.vue'),
    props: true
  },
  {
    path: '/register',
    name: 'register',
    component: () => import(/* webpackChunkName: "about" */ '../views/RegisterView.vue'),
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/LoginView.vue'),
  },
  {
    path: '/notice',
    name: 'notice',
    component: () => import(/* webpackChunkName: "about" */ '../views/NoticeView.vue'),
  },
  {
    path: '/detail',
    name: 'detail',
    component: () => import(/* webpackChunkName: "about" */ '../views/NoticeDetailView.vue'),
    props: true
  },
  {
    path: '/notice/write',
    name: 'noticeWrite',
    component: () => import(/* webpackChunkName: "about" */ '../views/NoticeWriteView.vue'),
  },
  {
    path: '/notice/update',
    name: 'noticeUpdate',
    component: () => import(/* webpackChunkName: "about" */ '../views/NoticeUpdateView.vue'),
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
