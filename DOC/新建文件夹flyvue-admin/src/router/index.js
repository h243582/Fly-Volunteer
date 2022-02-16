import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },
  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: { title: '基本信息管理', icon: 'example' },
    children: [
      { path: 'city', name: 'city', component: () => import('@/views/table/city'), meta: { title: 'city', icon: 'table' }},
      { path: 'course', name: 'course', component: () => import('@/views/table/course'), meta: { title: 'course', icon: 'table' }},
      { path: 'courseMajor', name: 'courseMajor', component: () => import('@/views/table/courseMajor'), meta: { title: 'courseMajor', icon: 'table' }},
      { path: 'department', name: 'department', component: () => import('@/views/table/department'), meta: { title: 'department', icon: 'table' }},
      { path: 'departmentType', name: 'departmentType', component: () => import('@/views/table/departmentType'), meta: { title: 'departmentType', icon: 'table' }},
      { path: 'gradeSchoolMajorYear', name: 'gradeSchoolMajorYear', component: () => import('@/views/table/gradeSchoolMajorYear'), meta: { title: 'gradeSchoolMajorYear', icon: 'table' }},
      { path: 'levels', name: 'levels', component: () => import('@/views/table/levels'), meta: { title: 'levels', icon: 'table' }},
      { path: 'major', name: 'major', component: () => import('@/views/table/major'), meta: { title: 'major', icon: 'table' }},
      { path: 'majorCategory', name: 'majorCategory', component: () => import('@/views/table/majorCategory'), meta: { title: 'majorCategory', icon: 'table' }},
      { path: 'majorInformation', name: 'majorInformation', component: () => import('@/views/table/majorInformation'), meta: { title: 'majorInformation', icon: 'table' }},
      { path: 'majorInterpretation', name: 'majorInterpretation', component: () => import('@/views/table/majorInterpretation'), meta: { title: 'majorInterpretation', icon: 'table' }},
      { path: 'majorLevelsType', name: 'majorLevelsType', component: () => import('@/views/table/majorLevelsType'), meta: { title: 'majorLevelsType', icon: 'table' }},
      { path: 'majorProfessionalCategory', name: 'majorProfessionalCategory', component: () => import('@/views/table/majorProfessionalCategory'), meta: { title: 'majorProfessionalCategory', icon: 'table' }},
      { path: 'majorProvinceMoney', name: 'majorProvinceMoney', component: () => import('@/views/table/majorProvinceMoney'), meta: { title: 'majorProvinceMoney', icon: 'table' }},
      { path: 'majorSimilarMajor', name: 'majorSimilarMajor', component: () => import('@/views/table/majorSimilarMajor'), meta: { title: 'majorSimilarMajor', icon: 'table' }},
      { path: 'majorVocation', name: 'majorVocation', component: () => import('@/views/table/majorVocation'), meta: { title: 'majorVocation', icon: 'table' }},
      { path: 'majorVocationMajor', name: 'majorVocationMajor', component: () => import('@/views/table/majorVocationMajor'), meta: { title: 'majorVocationMajor', icon: 'table' }},
      { path: 'province', name: 'province', component: () => import('@/views/table/province'), meta: { title: 'province', icon: 'table' }},
      { path: 'recruitmentBrochure', name: 'recruitmentBrochure', component: () => import('@/views/table/recruitmentBrochure'), meta: { title: 'recruitmentBrochure', icon: 'table' }},
      { path: 'school', name: 'school', component: () => import('@/views/table/school'), meta: { title: 'school', icon: 'table' }},
      { path: 'schoolInformation', name: 'schoolInformation', component: () => import('@/views/table/schoolInformation'), meta: { title: 'schoolInformation', icon: 'table' }},
      { path: 'schoolMajor', name: 'schoolMajor', component: () => import('@/views/table/schoolMajor'), meta: { title: 'schoolMajor', icon: 'table' }},
      { path: 'type', name: 'type', component: () => import('@/views/table/type'), meta: { title: 'type', icon: 'table' }},
      { path: 'user', name: 'user', component: () => import('@/views/table/user'), meta: { title: 'user', icon: 'table' }},
      { path: 'year', name: 'year', component: () => import('@/views/table/year'), meta: { title: 'year', icon: 'table' }},

      { path: 'user', name: 'table', component: () => import('@/views/table/user'), meta: { title: '用户管理', icon: 'table' }}
    ]
  },
  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

