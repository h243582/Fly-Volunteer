import Cookie from "js-cookie";

const tokenKey = "X-Token"; //Token
const idKey = "id"; //用户id
const emailKey = "email"; //邮箱
const nameKey = "nickname"; //名字
const avatarKey = "avatar"; //用户头像
const isvipKey = "isvip"; //vip


export function setUser(id, token, email, nickname, avatar, vip) {
    Cookie.set(idKey, id);
    Cookie.set(tokenKey, token);
    Cookie.set(emailKey, email);
    Cookie.set(nameKey, nickname);
    Cookie.set(avatarKey, avatar);
    Cookie.set(isvipKey, vip);
}

export function setAvatar(avatar) {
    Cookie.set(avatarKey, avatar);
}

export function getUser() {
    return {
        id: Cookie.get(idKey),
        token: Cookie.get(tokenKey),
        email: Cookie.get(emailKey),
        name: Cookie.get(nameKey),
        avatar: Cookie.get(avatarKey),
        isvip: Cookie.get(isvipKey),
    };
}

export function removeUser() {
    Cookie.remove(idKey);
    Cookie.remove(tokenKey);
    Cookie.remove(emailKey);
    Cookie.remove(nameKey);
    Cookie.remove(avatarKey);
    Cookie.remove(isvipKey);
}

