import axios from "axios";
import {getUser} from "@/utils/auth";

// 创建axios实例
const service = axios.create({
    baseURL: "http://localhost:2435",
    timeout: 15000,     // 请求超时时间
    headers: {'Authorization': getUser().token}  // 定义头信息，每次请求都将头信息带过去
});

// 导出
export default service;










