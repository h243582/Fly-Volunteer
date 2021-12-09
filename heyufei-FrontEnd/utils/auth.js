import Cookie from "js-cookie";

const tokenKey = "X-Token"; //Token
const nameKey = "userName"; //用户名
const avatarKey = "userAvatar"; //用户头像
const idKey = "userId"; //用户id


export function setUser(id, token, name, avatar) {
    Cookie.set(idKey, id);
    Cookie.set(tokenKey, token);
    Cookie.set(nameKey, name);
    Cookie.set(avatarKey, avatar);
}
// export function setUser(token, name, avatar) {
//     Cookie.set(tokenKey, token);
//     Cookie.set(nameKey, name);
//     Cookie.set(avatarKey, avatar);
// }

export function setAvatar(avatar) {
    Cookie.set(avatarKey, avatar);
}

export function getUser() {
    return {
        id: Cookie.get(idKey),
        token: Cookie.get(tokenKey),
        name: Cookie.get(nameKey),
        avatar: Cookie.get(avatarKey),
    };
}

export function removeUser() {
    Cookie.remove(idKey);
    Cookie.remove(tokenKey);
    Cookie.remove(nameKey);
    Cookie.remove(avatarKey);
}

