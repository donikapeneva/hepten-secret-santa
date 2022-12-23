import httpRequest from '../utils/httpRequest';

export const getRoom = (id ) => httpRequest.get('/rooms/' + id);

export const createRoom = (createRoomPojo ) => {

    return httpRequest.post('/rooms/', getCreateRoomDto(createRoomPojo));
}


const getCreateRoomDto = (pojo) => ({
    roomName: pojo.roomName,
    passCode: pojo.roomPassCode,
    budget: pojo.budget,
    giftTheme: pojo.giftTheme,
    nicknameThemeCategory: pojo.codeNamesTheme,
    creatorUsername: 'donika',
    // genderReviel: false
});