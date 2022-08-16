import { createApp } from 'vue';
import App from './App.vue';
import PrimeVue from 'primevue/config';
import InputText from "primevue/inputtext";
import Button from "primevue/button";
import Dialog from 'primevue/dialog';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import RadioButton from 'primevue/radiobutton';
import ToastService from 'primevue/toastservice';
import Toast from 'primevue/toast';
import Dropdown from 'primevue/dropdown';
import TabMenu from 'primevue/tabmenu';
import Divider from 'primevue/divider';
import Card from 'primevue/card';
import Menubar from 'primevue/menubar';
import Password from 'primevue/password';
import Calendar from 'primevue/calendar';
import InputNumber from 'primevue/inputnumber';



import SelectButton from 'primevue/selectbutton';

import '/node_modules/primeflex/primeflex.css';             // prime flex



import 'primevue/resources/themes/saga-blue/theme.css'       //theme
import 'primevue/resources/primevue.min.css'                //core css
import 'primeicons/primeicons.css'                          //icons
import router from './router'




const app = createApp(App).use(router); //1

app.use(PrimeVue); //2
app.use(ToastService);
app.component('InputText', InputText);
app.component('Card', Card);
app.component('Button', Button);
app.component('Dialog', Dialog);
app.component('DataTable', DataTable);
app.component('Column', Column);
app.component('RadioButton', RadioButton);
app.component('Toast', Toast);
app.component('TabMenu', TabMenu);
app.component('Dropdown', Dropdown);
app.component('Divider', Divider);
app.component('Menubar', Menubar);
app.component('Password', Password);
app.component("SelectButton", SelectButton);
app.component('Calendar', Calendar);
app.component('InputNumber', InputNumber);
app.mount('#app'); //muy importante poner esto al final

