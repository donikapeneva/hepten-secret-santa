import React, { useEffect, useState } from 'react';
import Backdrop from '@mui/material/Backdrop';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import Fade from '@mui/material/Fade';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};


const EnterRoomModal = ({ open, onClose }) => {

    const [roomName, setRoomName] = useState();
    const [roomPass, setRoomPass] = useState();
    const [username, setUsername] = useState();
    
    const [validationErrors, setValidationErrors] = useState();

    const validateForm = () => {
        if(!roomName) {
            setValidationErrors(currentErrors => ({...currentErrors, roomNameError: true}));
        }
        if(!roomPass) {
            setValidationErrors(currentErrors => ({...currentErrors, roomPassError: true}));
        }
        if(!username) {
            setValidationErrors(currentErrors => ({...currentErrors, usernameError: true}));
        }
        
    }

    const resetErrors = (field) => {
        if (validationErrors && !field) {
            setValidationErrors();
        } else if (validationErrors) {
            const newErrors = validationErrors;
            Object.keys(newErrors)?.forEach((item) => {
                if(item === field) {
                    newErrors[item] = false;
                }
            });
            setValidationErrors(newErrors);
        }
    }

    const onRoomNameChange = (e) => {
        resetErrors('roomNameError');
        setRoomName(e.target.value);

    }
    const onRoomPassChange = (e) => {
        resetErrors('roomPassError');
        setRoomPass(e.target.value);
    }
    
    const onUsernameChange = (e) => {
        resetErrors('usernameError');
        setUsername(e.target.value);
    }

    const handleEnterRoom = () => {
        validateForm();
        const enterRoomData = {
            roomName: roomName,
            roomPassCode: roomPass,
            username: username
        }
        //todo send to BE
    }

    return (
      <div>
        <Modal
          aria-labelledby="transition-modal-title"
          aria-describedby="transition-modal-description"
          open={open}
          onClose={() => {
            onClose();
            resetErrors();
        }}
          closeAfterTransition
          BackdropComponent={Backdrop}
          BackdropProps={{
            timeout: 500,
          }}
        >
          <Fade in={open}>
            <Box sx={style} className="form-field-center">
                <Stack
                    direction="column"
                    justifyContent="center"
                    alignItems="stretch"
                    spacing={2}
                    >
                        {/* <FormGroup> */}
                        <TextField 
                            id="standard-basic" 
                            label="Room Name" 
                            variant="standard" 
                            onChange={onRoomNameChange}
                            error={validationErrors?.roomNameError}
                        />
                        <TextField 
                            id="standard-basic"
                            label="Pass Code" 
                            variant="standard" 
                            onChange={onRoomPassChange}
                            error={validationErrors?.roomPassError}
                        />
                        <TextField 
                            id="standard-basic"
                            label="Username" 
                            variant="standard" 
                            onChange={onUsernameChange}
                            error={validationErrors?.usernameError}
                        />

                        <Button 
                            variant="outlined"
                            onClick={handleEnterRoom}>
                                enter room
                            </Button>
                        {/* </FormGroup> */}
                </Stack>
            </Box>
          </Fade>
        </Modal>
      </div>
    );
  }

  export default EnterRoomModal;