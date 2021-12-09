import request from '@/utils/request'

export default {
    sendsms(mobile) {
        return request({
            url: `/user/sendsms/${mobile}`,
            method: "post",
        });
    },
    register(user, code) {
        return request({
            url: `/user/register/${code}`,
            method: "post",
            data: user,
        });
    },
    //使用微信登录添加新用户
    add(user){
      return request({
          url:"/user",
          method:"post",
          data:user,
      });
    },
    login(mobile, password) {
        return request({
            url: "/user/login",
            method: "post",
            data: {
                mobile,
                password,
            },
        });
    },
    logout() {
        return request({
          url: "/user/logout",
          method: 'post'
        })
    },
    /*根据cookie的token查询我的个人信息*/
    getInfo(token){
        return request({
            url: "/user/info",
            method:"get",
            params: { token }
        });
    },
    info() {
        return request({
          url: `/user/info`,
          method: 'get'
        })
    },
    /*根据用户id查询我的个人信息*/
    getInfoById(uid){
        return request({
           url : `/user/${uid}`,
            method: "get"
        });
    },

    //获取当前登录的用户的账户信息
    getAccount(){
        return request({
            url: `/user/info`,
            method:"get"
        })
    },
    //修改账户信息
    saveinfo(user) {
        return request({
          url: "/user/saveinfo",
          method: 'put',
          data:user
        })
    },
    //查询当前登录用户的用户信息
    getUser(){
        return new request({
           url: "/user/info",
           method:"get",
        });
    },
    //修改用户信息
    updateUser(pojo){
        return new request({
            url: `/user/`,
            method:"put",
            data:pojo,
        });
    },

    //设置用户头像
    setAvator(uid,url){
        let pojo={
          uid:uid,
          url:url
        };
        return new request({
           url:`/user/setAvator` ,
            method:"put",
            data:pojo
        });
    }
}



