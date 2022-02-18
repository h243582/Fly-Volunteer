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
            url: `/${api_name}/sendsms?email=${email}`,
            method: "post",
        });
    },
    //管理员界面新增用户
    addUser(user) {
        return request({
            url: `/${api_name}`,
            method: "post",
            data: user,
        });
    },
    register(user, code) {
        return request({
            url: `/${api_name}/register/${code}`,
            method: "post",
            data: user,
        });
    },

    login(email, password) {
        return request({
            url: `/${api_name}/login`,
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
    findByEmail(email) {
        return request({
            url: `/${api_name}/email?email=${email}`,
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


    //修改用户信息
    updateUser(id, pojo) {
        if (id === null || id === '') {
            return this.save(pojo)
        }
        return request({
            url: `/${api_name}/${id}`,
            method: 'put',
            data: pojo
        })
    },
    deleteById(id) {
        return request({
            url: `/${api_name}/${id}`,
            method: 'delete'
        })
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



