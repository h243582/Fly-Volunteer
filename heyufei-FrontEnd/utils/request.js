import axios from "axios";
import {getUser} from "@/utils/auth";

// 创建axios实例
const service = axios.create({
    // baseURL: "http://192.168.153.138:7300/mock/60127e6734ce0d001f98e2fd",
    baseURL: "http://localhost:9012",
    timeout: 15000,     // 请求超时时间
    headers: {'Authorization': 'HeYuFei: '+getUser().token}  // 定义头信息，每次请求都将头信息带过去
});

// 导出
export default service;










