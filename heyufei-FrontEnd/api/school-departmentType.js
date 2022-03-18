import request from '@/utils/request'
const api_name = 'departmentType'
export default {
  getList() {
    return request({
      url: `/${api_name}`,
      method: 'get'
    })
  },
  findAllLimit(currentPage,pageSize){
    return request({
      url: `/${api_name}/${currentPage}/${pageSize}`,
      method: 'get'
    })
  },
  save(pojo) {
    return request({
      url: `/${api_name}`,
      method: 'post',
      data: pojo
    })
  },
  findById(id) {
    return request({
      url: `/${api_name}/${id}`,
      method: 'get'
    })
  },
  update(id, pojo) {
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
  }
}
