import httpRequest from '../utils/httpRequest';

export const getNicknameThemes = ( ) => httpRequest.get(`/themes/nicknames`)
    .then((res) => res.data.categories);

export const getGiftThemes = ( ) => httpRequest.get(`/themes/gift`)
    .then((res) => res.data.categories);
