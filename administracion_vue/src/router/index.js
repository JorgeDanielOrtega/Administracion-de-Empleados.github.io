import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/perfil', //todo mas tarde, agregarle un id
    name: 'perfil',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    
    component: () => import(/* webpackChunkName: "perfil" */ '../views/PerfilEmpleado.vue')
  },
  {
    path: '/perfil/:id/asistencia',
    name: 'asistenciaEmpleado',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    
    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/AsistenciaEmpleado.vue')
  },
  {
    path: '/departamento/:id',
    name: 'departamento',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    
    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../components/DepartamentoEmpleado.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
