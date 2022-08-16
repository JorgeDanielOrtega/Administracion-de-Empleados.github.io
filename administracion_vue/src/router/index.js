import { createRouter, createWebHashHistory } from 'vue-router'
//import HomeView from '../views/Login.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    //component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
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
    // path: '/perfil', //todo mas tarde, agregarle un id
    path: '/perfil/:id', //todo mas tarde, agregarle un id
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
  },
  {
    path: '/asistencia/:id',
    name: 'asistencia',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../components/Asistencia.vue')
  },
  {
    path: '/busqueda',
    name: 'busqueda',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Busqueda.vue')
  },
  {
    path: '/roles',
    name: 'roles',
    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Rol.vue')
  },
  {
    path: '/empleado',
    name: 'empleado',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Empleado.vue')
  },
  {
    path: '/departamentos',
    name: 'departamentos',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Departamentos.vue')
  }, 
  {
    path: '/empresa',
    name: 'empresa',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Empresa.vue')
  },
  {
    path: '/decimo',
    name: 'decimo',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Decimo.vue')
  },
  {
    path: '/pokemon',
    name: 'pokemon',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/PokeApi.vue')
  },
  {
    path: '/departamentosCRUD',
    name: 'departamentosCRUD',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Departamentos.vue')
  },
  {
    path: '/rolesCRUD',
    name: 'rolesCRUD',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Rol.vue')
  },
  {
    path: '/empleadosCRUD',
    name: 'empleadosCRUD',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.

    component: () => import(/* webpackChunkName: "asistenciaEmpleado" */ '../views/Empleado.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
