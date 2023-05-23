import React, { useState } from 'react';  
import './Home.css';
import Button from '@mui/material/Button';
import { Typography } from '@mui/material';
import CreateRoomModal from '../../components/CreateRoomModal';
import EnterRoomModal from '../../components/EnterRoomModal';

const Header = () => {

    const [openCreateRoom, setOpenCreateRoom] = useState(false);
    const handleOpenCreateRoom = () => setOpenCreateRoom(true);
    const handleCloseCreateRoom = () => setOpenCreateRoom(false);

    
    const [openEnterRoom, setOpenEnterRoom] = useState(false);
    const handleOpenEnterRoom = () => setOpenEnterRoom(true);
    const handleCloseEnterRoom = () => setOpenEnterRoom(false);

  return (
    <div className="container">
      <div className="accent-title">
      <Typography  variant="h1">
        Hepten Secret Santa
      </Typography>
      </div>
      <Button variant="outlined" onClick={handleOpenCreateRoom}> 
        Create room
      </Button>
      <CreateRoomModal open={openCreateRoom} onClose={handleCloseCreateRoom}/>

      <Button variant="outlined" onClick={handleOpenEnterRoom}> 
        Enter room
      </Button>
      <EnterRoomModal open={openEnterRoom} onClose={handleCloseEnterRoom}/>

      <Button>
        How does it work
      </Button>
    </div>
  );
};

export default Header;