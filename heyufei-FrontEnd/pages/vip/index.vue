<template>
  <div>
    <div class="container-frame mt20">
      <div class="col900 card-buy-v3">

        <div style="width: 360px;height: 429px;float:left;">
          <el-carousel height="429px">
            <el-carousel-item v-for="item in rotation" :key="item">
              <el-image class="small" :src="item" style="width: 360px;height: 400px"/>
            </el-carousel-item>
          </el-carousel>
        </div>

        <div class="card-info">
          <h3 id="card-title">志愿卡（VIP）</h3>
          <h4>考试院专家推荐平台，录取参考数据与省考试院完全一致77</h4>
          <div class="card-price">
            价格<b id="now-price">￥360</b>
            <span id="base-price" class="text-though">原价：￥698</span>
          </div>
          <div class="card-type">
            <a class="type" data-type="1" id="type1" href="javascript:;">
              <span>志愿卡</span><br/>
              (VIP)
            </a>
          </div>
          <div class="card-buy-btn">
            <a class="btn btn-primary js-onlineBuy" @click="dialogVisible = true" style="width:300px;">立即购买</a>
            <div
                style="cursor:pointer;position:absolute;right:180px;top:6px;padding:0 10px;height:26px;color:#fff;background:#e84c33;text-align: center;line-height:26px;border-radius: 20px;"
                onclick="javascript:window.open('https://cschat.antcloud.com.cn/index.htm?tntInstId=ZQt_tVYL&scene=SCE00289629','','width=800,height=600');">
              <img src="//staticv3-pre.youzy.cn/ToC.PC/images/common/service.gif" width="18" class="mr5">客服
            </div>
            <div class="tel" style="background:none;">咨询热线：400-181-5008</div>
          </div>
          <div class="type1 " style="font-size: 14px">
            <p>1、开通志愿卡畅享查、测、填、学、问5大核心功能。</p>
            <p>2、1000部学长学姐讲专业、500部专家讲志愿在线视频讲座，帮助考生科学填志愿。</p>
            <p>3、适用对象：普通类文理科考生、新高考选科类考生（提前批次及艺术体育类考生暂不适用）。</p>
            <p>4、使用时效：有效期截止到用户自行选择高考年的9月1日为止（非高考年,高考期间仅提供数据查询）。</p>
            <!-- <p style="color: red">5、上海不提供普通类“专科批次”模拟填报服务（全端设备）</p> -->
            <p style="color: red">5、陕西不提供普通类文理“单设本科批次”模拟填报服务（全端设备）</p>
          </div>
          <div class="type2 hide" style="font-size: 14px">
            <p>1、升学卡适用于高一、高二、高三学生课程学习。名师执教紧跟命题方向，深谙考生学习规律，全科辅导，快速提分。</p>
            <p>2、畅享志愿卡全部功能。</p>
            <p>3、适用对象：普通类文理科考生、新高考选科类考生（提前批次及艺术体育类考生暂不适用）。</p>
            <p>4、使用时效：有效期截止到用户自行选择高考年的9月1日为止（非高考年,高考期间仅提供数据查询）。</p>
            <!-- <p style="color: red">5、上海不提供普通类“专科批次”模拟填报服务（全端设备）</p> -->
            <p style="color: red">5、陕西不提供普通类文理“单设本科批次”模拟填报服务（全端设备）</p>
          </div>
        </div>

        <!--    充值会员弹出框    -->
        <el-dialog
            title="充值会员"
            :visible.sync="dialogVisible"
            width="50%">
          <div class="demo-image__placeholder">
            <div class="block">
              <el-image style="width: 100px; height: 100px" :src="skm1"></el-image>
              <el-image style="width: 100px; height: 100px" :src="skm2"></el-image>
            </div>
          </div>


          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
        </el-dialog>
      </div>
    </div>

    <!-- 底部 -->
    <div class="uzy-foot-wra uzy-foot-wraV2">
      <div class="uzy-links">
        <div class="section">
          <div class="home-title">友情链接</div>
          <ul class="clearfix">
            <li><a href="http://www.eagersoft.cn/" title="亿阁教育" target="_blank">亿阁教育</a></li>
            <li><a href="http://www.yingsheng.com/topic/1692" title="培训体系" target="_blank">培训体系</a></li>
            <li><a href="http://www.youzy.cn/" title="高考志愿填报" target="_blank">高考志愿填报</a></li>
            <li><a href="http://zuowen.xuexila.com/" title="优秀作文范文" target="_blank">优秀作文范文</a></li>
            <li><a href="http://xialinying.com/" title="军事夏令营" target="_blank">军事夏令营</a></li>
            <li><a href="http://www.huatu.com/a/gwy/" title="省公务员考试	" target="_blank">省公务员考试 </a></li>
          </ul>
        </div>
      </div>
      <!--  底下四个图片  -->
      <div class="uzy-action">
        <div class="section">
          <div class="font">
            <img src="//staticv2.youzy.cn/images/footer/data.png">
          </div>
          <div class="font">
            <img src="//staticv3-pre.youzy.cn/ToC.PC/images/footer/fillin.png">
          </div>
          <div class="font">
            <img src="//staticv2.youzy.cn/images/footer/change.png">
          </div>
          <div class="font mr0">
            <img src="//staticv2.youzy.cn/images/footer/belive.png">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {getUser} from "@/utils/auth";
import '~/assets/css/vip.css'

export default {
  data() {
    return {
      rotation: [
        require('~/assets/img/vip1.jpg'),
        require('~/assets/img/vip2.jpg'),
        require('~/assets/img/vip3.jpg'),
        require('~/assets/img/vip4.jpg'),
      ],
      dialogVisible: false,
      skm1:require('~/assets/img/收款码1.png'),
      skm2:require('~/assets/img/收款码2.png'),


    }
  },
  created() {
    this.user = getUser()
    console.log(this.user)
  },
  methods: {

  }
}
</script>
<div class="nail hd">
<ul>
  <li class="on">
    <img src="//staticv2.youzy.cn/images/usercenter/vip/v4/300-1.jpg" width="66" height="66"/>
  </li>
  <li>
    <img src="//staticv2.youzy.cn/images/usercenter/vip/v4/300-2.jpg" width="66" height="66"/>
  </li>
  <li>
    <img src="//staticv2.youzy.cn/images/usercenter/vip/v4/300-3-new.jpg" width="66"
         height="66"/>
  </li>
  <li class="mr0">
    <img src="//staticv2.youzy.cn/images/usercenter/vip/v4/300-4.jpg" width="66" height="66"/>
  </li>
</ul>
</div>
