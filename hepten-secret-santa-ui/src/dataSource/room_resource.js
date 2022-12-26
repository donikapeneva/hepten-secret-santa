import httpRequest from '../utils/httpRequest';

export const getRoom = (id ) => httpRequest.get(`/rooms/${id}/info`)
.then((res) => res.data)
.then(data => getViewRoomDtoToPojo(data)) ;

export const createRoom = (createRoomPojo ) => {

    return httpRequest.post('/rooms', getCreateRoomDto(createRoomPojo));
}

export const revealRoom = (id ) => httpRequest.put(`/rooms/${id}/reveal`);

const getViewRoomDtoToPojo = (dto) => ({
    budget: dto.budget ?  dto.budget : '',
    giftsExchangeList: dto.mapping
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