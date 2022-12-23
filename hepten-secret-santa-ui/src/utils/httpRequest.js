import axios from 'axios';
import { MS_BACKEND_URL } from './constants';

// const getAuthorizationHeader = () => {
//     const token = window.localStorage.getItem('accessToken');
//     return { Authorization: `Bearer ${token}` };
// };

const getRequest = async (path, params) => axios.get(
    MS_BACKEND_URL + path,
    params ? { params, 
        // headers: getAuthorizationHeader() } : { headers: getAuthorizationHeader() 
        } : {});

const postRequest = (path, body) => axios.post(
    MS_BACKEND_URL + path, body,
    {mode: "cors"},
    // { headers: getAuthorizationHeader() }
    );

const putRequest = (path, body) => axios.put(
    MS_BACKEND_URL + path, body,
    // { headers: getAuthorizationHeader() }
    );

const patchRequest = (path, body) => axios.patch(
    MS_BACKEND_URL + path, body,
    // { headers: getAuthorizationHeader() }
    );

const deleteRequest = (path) => axios.delete(
    MS_BACKEND_URL + path,
    // { headers: getAuthorizationHeader() }
    );

const httpRequest = {
    get: getRequest,
    post: postRequest,
    put: putRequest,
    patch: patchRequest,
    delete: deleteRequest
};

export default httpRequest;
