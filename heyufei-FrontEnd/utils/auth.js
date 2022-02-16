import Cookie from "js-cookie";

const tokenKey = "X-Token"; //Token
const nameKey = "email"; //邮箱
const avatarKey = "userAvatar"; //用户头像
const idKey = "userId"; //用户id
const isVIP = "isVIP"; //vip


export function setUser(id, token, nickname, avatar, vip) {
    Cookie.set(idKey, id);
    Cookie.set(tokenKey, token);
    Cookie.set(nameKey, nickname);
    Cookie.set(avatarKey, avatar);
    Cookie.set(isVIP, vip);
}

export function setAvatar(avatar) {
    Cookie.set(avatarKey, avatar);
}

export function getUser() {
    return {
        id: Cookie.get(idKey),
        token: Cookie.get(tokenKey),
        name: Cookie.get(nameKey),
        avatar: Cookie.get(avatarKey),
        isvip: Cookie.get(isVIP),
    };
}

export function removeUser() {
    Cookie.remove(idKey);
    Cookie.remove(tokenKey);
    Cookie.remove(nameKey);
    Cookie.remove(avatarKey);
    Cookie.remove(isVIP);
}

