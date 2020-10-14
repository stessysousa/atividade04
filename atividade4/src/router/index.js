import Vue from 'vue'
import VueRouter from 'vue-router'
import Buscar from '../components/Buscar.vue'
import Cadastrar from '../components/Cadastrar.vue'
import Filtrar from '../components/Filtrar.vue'
import Editar from '../components/Editar.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/buscar',
        name: 'Buscar',
        component: Buscar
    },

    {
        path: '/cadastrar',
        name: 'Cadastrar',
        component: Cadastrar
    },

    {
        path: '/filtrar',
        name: 'Filtrar',
        component: Filtrar
    },

    {
        path: '/editar',
        name: 'Editar',
        component: Editar
    },

    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: function() {
            return import ( /* webpackChunkName: "about" */ '../views/About.vue')
        }
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router