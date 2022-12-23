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

const getRevialedData = () => {
    //make call to BE
    return {
        budget: 10,
        giftsExchangeList: [
            {
                giver: 'Test1',
                receiver: 'Fake Name 5',
                receiverRealName: 'Test2',
                giftTheme: 'asd'
            },
            {
                giver: 'Test2',
                receiver: 'Fake Name 5',
                receiverRealName: 'Test2',
                giftTheme: 'asd'
            },
            {
                giver: 'Test3',
                receiver: 'Fake Name 5',
                receiverRealName: 'Test2',
                giftTheme: 'asd'
            },
        ]
    }
}


const Room = () => {

    const [roomInfo, setRoomInfo] = useState({});

    const handleRevial = () => {
        console.log('>>>> change');
        setRoomInfo(getRevialedData());
    }


    useEffect(() => {
        setRoomInfo(getMockedRoomInfo());

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
                                            {exchange.receiver + (exchange.receiverRealName ? `(${exchange.receiverRealName})` : '' )}
                                        </TableCell>
                                        <TableCell align="right">{exchange.giftTheme}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                    
                </div>

                <div className="container">
                    <Button variant="contained" onClick={handleRevial}>
                        Revial
                    </Button>
                </div>


            </div>
        </>
    );
};

export default Room;