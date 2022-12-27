import React, { useState } from 'react';

import { Typography } from '@mui/material';

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';
import { useEffect } from 'react';
import { getRoom, revealRoom, startRoom } from '../../dataSource/room_resource';

import { useLocation } from "react-router-dom";


const Room = () => {

    const [roomInfo, setRoomInfo] = useState({});
    const { state } = useLocation();
    const { roomId } = state;

    const handleReveal = () => {
        console.log('>>>> change');
        revealRoom(roomId);
        getRoom(roomId)
            .then(data => {
                console.log('>> room ingo', data);
                setRoomInfo(data)});
        // setRoomInfo(getRevealedData());
    }

    const handleStart = () => {
        console.log('>>>> change');
        startRoom(roomId);
        getRoom(roomId)
            .then(data => {
                console.log('>> room ingo', data);
                setRoomInfo(data)});
        // setRoomInfo(getRevealedData());
    }


    useEffect(() => {
        getRoom(roomId)
            .then(data => setRoomInfo(data));
    }, []);

    return (
        <>
            <div className="container">
                <div className="accent-title">
                    <Typography variant="h1">
                        Presents Exchange
                    </Typography>
                    <Typography align="center">budget: {roomInfo.budget}</Typography>
                </div>

                <div className="container">
                    <TableContainer >
                        <Table sx={{ width: 650}} aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Giver</TableCell>
                                    <TableCell align="right">Receiver</TableCell>
                                    <TableCell align="right">Gift Theme</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {roomInfo && roomInfo.giftsExchangeList && roomInfo.giftsExchangeList.map((exchange) => (
                                    <TableRow
                                        key={exchange.giver}
                                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                    >
                                        <TableCell component="th" scope="row">
                                            {exchange.giver}
                                        </TableCell>
                                        <TableCell align="right">
                                            {exchange.receiverNickname + (exchange.receiver ? `(${exchange.receiver})` : '' )}
                                        </TableCell>
                                        <TableCell align="right">{exchange.giftThemes ? exchange.giftThemes.join(', ') : ''}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                    
                </div>

                <div className="container">
                    {roomInfo && roomInfo.status === 'STARTED' && (
                        <Button variant="contained" onClick={handleReveal}>
                            Reveal
                        </Button>
                    ) }
                    {roomInfo && roomInfo.status === 'INITIALIZED' && (
                        <Button variant="contained" onClick={handleStart}>
                            Start room
                        </Button>
                    ) }
                    
                </div>


            </div>
        </>
    );
};

export default Room;