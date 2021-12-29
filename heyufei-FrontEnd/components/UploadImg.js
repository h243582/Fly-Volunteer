const COS = require('cos-js-sdk-v5')
// 填写自己腾讯云cos中的key和id (密钥)
const cos = new COS({
    SecretId: 'AKIDY2PVXMBrCMQYUFwfGi40kPq1QcYCckdf', // 身份识别ID
    SecretKey: 'z8x43NhlbFFVdW7ZptIRKyMh1A4uWtSR' // 身份秘钥
})
