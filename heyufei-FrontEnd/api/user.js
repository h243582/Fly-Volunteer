import request from '@/utils/request'
const group_name = ''
const api_name = 'user'

export default {
    /*查询所有用户分页*/
    getAllUserListLimit(page, size) {
        console.log("getAllUserListLimit:" + "," + page + "," + size)
        let searchMap = {}
        return new request({
            url: `user/search/${page}/${size}`,
            method: 'post',
            data: searchMap
        })

    },
    search(page, size, searchMap) {
        return request({
            url: `/${api_name}/search/${page}/${size}`,
            method: 'post',
            data: searchMap
        })
    },
    sendsms(email) {
        return request({
            url: `/user/sendsms?email=${email}`,
            method: "post",
        });
    },
    register(user, code) {
        // console.log(user + "-----" + code)
        return request({
            url: `/user/register/${code}`,
            method: "post",
            data: user,
        });
    },
    //使用微信登录添加新用户
    add(user) {
        return request({
            url: "/user",
            method: "post",
            data: user,
        });
    },
    login(email, password) {
        return request({
            url: "/heyufei-user/user/login",
            method: "post",
            data: {
                email,
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
    getInfo(token) {
        return request({
            url: "/user/info",
            method: "get",
            params: {token}
        });
    },
    info() {
        return request({
            url: `/user/info`,
            method: 'get'
        })
    },
    /*根据用户id查询我的个人信息*/
    getInfoById(uid) {
        return request({
            url: `/user/${uid}`,
            method: "get"
        });
    },
    findById(id) {
        return request({
            url: `/${api_name}/${id}`,
            method: 'get'
        })
    },
    //获取当前登录的用户的账户信息
    getAccount() {
        return request({
            url: `/user/info`,
            method: "get"
        })
    },
    //修改账户信息
    saveinfo(user) {
        return request({
            url: "/user/saveinfo",
            method: 'put',
            data: user
        })
    },
    //查询当前登录用户的用户信息
    getUser() {
        return new request({
            url: "/user/info",
            method: "get",
        });
    },
    //修改用户信息
    updateUser(pojo) {
        return new request({
            url: `/user/`,
            method: "put",
            data: pojo,
        });
    },

    //设置用户头像
    setAvator(uid, url) {
        let pojo = {
            uid: uid,
            url: url
        };
        return new request({
            url: `/user/setAvator`,
            method: "put",
            data: pojo
        });
    }
}



