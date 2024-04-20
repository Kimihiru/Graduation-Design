import Vue from 'vue'
import Router from 'vue-router'
import welcome from "../welcome";
import Manage from "../components/Manage";
import User from "../components/User";
import AttractionInformation from "../components/AttractionInformation";
import Type from "../components/Type";
import Score from "../components/Score";
import Food from "../components/Food";
import First from "../components/First";
import TourList from "../components/TourList";
import Cart from "../components/Cart";
import Result from "../components/Result";
import PersonalRecommend from "../components/PersonalRecommend";
import Registration from "../components/Registration";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'welcome',
      component: welcome
    },
    {
      path:'/manage',
      name:'manage',
      component:Manage,
    },
    {
      path:'/user',
      name:'user',
      component:User
    },
    {
      path:'/attractionInformation',
      name:'attractionInformation',
      component:AttractionInformation
    },
    {
      path:'/type',
      name:'type',
      component:Type
    },
    {
      path:'/score',
      name:'score',
      component:Score
    },
    {
      path:'/food',
      name:'food',
      component:Food
    },
    {
      path:'/first',
      name:'first',
      component:First
    },
    {
      path:'/tourList',
      name:'tourList',
      component:TourList
    },
    {
      path:'/cart',
      name:'cart',
      component:Cart
    },
    {
      path:'/result',
      name:'result',
      component:Result
    },
    {
      path:'/personalRecommend',
      name:'personalRecommend',
      component:PersonalRecommend
    },
    {
      path:'/registration',
      name:'registration',
      component:Registration
    }
  ]
})
