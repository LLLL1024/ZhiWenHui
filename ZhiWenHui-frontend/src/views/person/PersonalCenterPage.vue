<template>
  <div id="personalCenterPage">
    <a-card>
      <a-row style="margin-bottom: 16px">
        <a-col flex="auto" class="content-wrapper">
          <h2>个人信息</h2>
          <p>昵称：{{ data.userName ?? "无名" }}</p>
          <p>个人简介：{{ data.userProfile ?? "无" }}</p>
          <p>角色：{{ data.userRole }}</p>
          <p>
            创建时间：{{ dayjs(data.createTime).format("YYYY-MM-DD HH:mm:ss") }}
          </p>
          <!-- <a-space size="medium">
            <a-button type="primary" @click="updata">更新修改信息</a-button>
          </a-space> -->
        </a-col>
        <a-col flex="220px">
          <a-image width="100%" :src="data.userAvatar" />
        </a-col>
      </a-row>
    </a-card>
  </div>
</template>

<script setup lang="ts">
import { computed, defineProps, ref, watchEffect, withDefaults } from "vue";
import API from "@/api";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { dayjs } from "@arco-design/web-vue/es/_utils/date";
import { useLoginUserStore } from "@/store/userStore";
import {
  getUserVoByIdUsingGet,
  updateMyUserUsingPost,
} from "@/api/userController";

const router = useRouter();

const data = ref<API.UserVO>({});

// 获取登录用户
const loginUserStore = useLoginUserStore();
const loginUserId = loginUserStore.loginUser?.id;

/**
 * 加载数据
 */
const loadData = async () => {
  const res = await getUserVoByIdUsingGet({
    id: loginUserId,
  });
  if (res.data.code === 0) {
    data.value = res.data.data as any;
  } else {
    message.error("获取数据失败，" + res.data.message);
  }
};

// todo 更新信息
// const updata = async (
//   record: API.UserUpdateMyRequest,
//   userName: string,
//   userAvatar: string,
//   userProfile: string
// ) => {
//   const res = await updateMyUserUsingPost({
//     userName,
//     userAvatar,
//     userProfile,
//   });
//   if (res.data.code === 0) {
//     data.value = res.data.data as any;
//   } else {
//     message.error("更新失败，" + res.data.message);
//   }
// };

/**
 * 监听 searchParams 变量，改变时触发数据的重新加载
 */
watchEffect(() => {
  loadData();
});
</script>

<style scoped>
#personalCenterPage {
}
</style>