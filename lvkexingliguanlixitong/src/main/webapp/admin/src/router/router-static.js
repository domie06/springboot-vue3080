import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import jianyi from '@/views/modules/jianyi/list'
    import tousu from '@/views/modules/tousu/list'
    import xingli from '@/views/modules/xingli/list'
    import yonghu from '@/views/modules/yonghu/list'
    import gongzuorenyuan from '@/views/modules/gongzuorenyuan/list'
    import dictionaryChuli from '@/views/modules/dictionaryChuli/list'
    import dictionaryJianyi from '@/views/modules/dictionaryJianyi/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryTousu from '@/views/modules/dictionaryTousu/list'
    import dictionaryXingli from '@/views/modules/dictionaryXingli/list'
    import dictionaryXingliYesno from '@/views/modules/dictionaryXingliYesno/list'
    import dictionaryXingliZhuangtai from '@/views/modules/dictionaryXingliZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryChuli',
        name: '是否处理',
        component: dictionaryChuli
    }
    ,{
        path: '/dictionaryJianyi',
        name: '建议类型',
        component: dictionaryJianyi
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryTousu',
        name: '投诉类型',
        component: dictionaryTousu
    }
    ,{
        path: '/dictionaryXingli',
        name: '行李类型',
        component: dictionaryXingli
    }
    ,{
        path: '/dictionaryXingliYesno',
        name: '审核状态',
        component: dictionaryXingliYesno
    }
    ,{
        path: '/dictionaryXingliZhuangtai',
        name: '行李状态',
        component: dictionaryXingliZhuangtai
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/jianyi',
        name: '建议',
        component: jianyi
      }
    ,{
        path: '/tousu',
        name: '工作人员投诉',
        component: tousu
      }
    ,{
        path: '/xingli',
        name: '行李托运',
        component: xingli
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/gongzuorenyuan',
        name: '工作人员',
        component: gongzuorenyuan
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
