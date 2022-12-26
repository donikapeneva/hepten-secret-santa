import httpRequest from '../utils/httpRequest';

export const getRoom = (id ) => httpRequest.get(`/rooms/${id}/info`)
.then((res) => res.data)
.then(data => getViewRoomDtoToPojo(data)) ;

export const createRoom = (createRoomPojo ) => {

    return httpRequest.post('/rooms', getCreateRoomDto(createRoomPojo));
}

export const revealRoom = (id ) => httpRequest.put(`/rooms/${id}/reveal`);

export const startRoom = (id ) => httpRequest.put(`/rooms/${id}/map-people`);

const getViewRoomDtoToPojo = (dto) => ({
    budget: dto.budget ?  dto.budget : '',
    giftsExchangeList: dto.mapping
});

export const enterRoom = (roomName, pojo) => {
    console.log('>>> ')
    return httpRequest.post(`/rooms/${roomName}/users`, getEnterRoomDto(pojo));
};

const getEnterRoomDto = (pojo) => ({
    username: pojo.username,
    passCode: pojo.roomPassCode,
    gender: 'n/a'
});


const getCreateRoomDto = (pojo) => ({
    roomName: pojo.roomName,
    passCode: pojo.roomPassCode,
    budget: pojo.budget,
    giftTheme: pojo.giftTheme,
    nicknameThemeCategory: pojo.codeNamesTheme,
    creatorUsername: 'donika',
    // genderReviel: false
});