import React, { useState } from 'react';

import Button from '@mui/material/Button';
import { Typography } from '@mui/material';
import CreateRoomModal from '../../components/CreateRoomModal';
import EnterRoomModal from '../../components/EnterRoomModal';

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useEffect } from 'react';

const getMockedRoomInfo = () => {
    return {
        budget: 10,
        giftsExchangeList: [
            {
                giver: 'Test1',
                receiver: 'Fake Name 5',
                giftTheme: 'asd'
            },
            {
                giver: 'Test2',
                receiver: 'Fake Name 5',
                giftTheme: 'asd'
            },
            {
                giver: 'Test3',
                receiver: 'Fake Name 5',
                giftTheme: 'asd'
            },
        ]
    }
}


const Room = () => {

    const [roomInfo, setRoomInfo] = useState({});


    useEffect(() => {
        setRoomInfo(getMockedRoomInfo());

    }, []);

    return (
        <>
            <div className="container">
                <div className="accent-title">
                    <Typography variant="h1">
                        Christmass Presents
                    </Typography>
                    <Typography align="center">budget: {roomInfo.budget}</Typography>
                </div>

                

                <div className="container">
                    <TableContainer >
                        <Table sx={{ width: 650}} aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Secret Santa</TableCell>
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
                                        <TableCell align="right">{exchange.receiver}</TableCell>
                                        <TableCell align="right">{exchange.giftTheme}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </div>
            </div>
        </>
    );
};

export default Room;