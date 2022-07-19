import { createApp } from 'vue';
import App from './App.vue';
//import VueRouter from 'vue-router';
//import Routes from "./routes";
import PrimeVue from 'primevue/config';
import InputText from "primevue/inputtext";
import Button from "primevue/button";
import Dialog from 'primevue/dialog';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';

import 'primevue/resources/themes/saga-blue/theme.css'       //theme
import 'primevue/resources/primevue.min.css'                //core css
import 'primeicons/primeicons.css'                         //icons
import router from './router'


const app = createApp(App).use(router); //1
//app.use(VueRouter);
app.use(PrimeVue); //2
app.component('InputText', InputText);
app.component('Button', Button);
app.component('Dialog', Dialog);
app.component('DataTable', DataTable);
app.component('Column', Column);
app.mount('#app'); //muy importante poner esto al final

