import React, { useEffect, useState } from 'react';
import Backdrop from '@mui/material/Backdrop';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import Fade from '@mui/material/Fade';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import MultipleSelect from './MultipleSelect';
import FancySelect from './FancySelect';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import { createRoom } from '../dataSource/room_resource';
import { getNicknameThemes, getGiftThemes } from '../dataSource/theme_resource';

import { useNavigate } from "react-router-dom";

// const mockedCodeNameThemes = [
//     'Famous People',
//     'Friends',
//     'Movies',
// ];

// const mockedGiftThemes = [
//     'Colors',
//     'Adjectives',
// ];

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


const CreateRoomModal = ({ open, onClose }) => {
    const navigate = useNavigate();
    const [codeNamesThemes, setCodeNamesThemes] = useState();
    const [giftThemes, setGiftThemes] = useState();

    const [roomName, setRoomName] = useState();
    const [roomPass, setRoomPass] = useState();
    const [codeNamesThemeSelected, setCodeNamesThemeSelected] = useState('');
    const [giftThemesSelected, setGiftThemesSelected] = useState([]);
    const [budget, setBudget] = useState();
    const [genderReviel, setGenderReviel] = useState();

    const [validationErrors, setValidationErrors] = useState();


    const validateForm = () => {
        if(!roomName) {
            setValidationErrors(currentErrors => ({...currentErrors, roomNameError: true}));
        }
        if(!roomPass) {
            setValidationErrors(currentErrors => ({...currentErrors, roomPassError: true}));
        }
        
        if(!codeNamesThemeSelected) {
            setValidationErrors(currentErrors => ({...currentErrors, codeNamesThemeError: true}));
        }
        
        if(!giftThemesSelected || giftThemesSelected.length === 0) {
            setValidationErrors(currentErrors => ({...currentErrors, giftThemesError: true}));
        }
        
        if(!budget) {
            setValidationErrors(currentErrors => ({...currentErrors, budgetError: true}));
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
    const onCodeNamesThemeSelectedChange = (e) => {
        resetErrors('codeNamesThemeError');
        setCodeNamesThemeSelected(e.target.value);
    };
    const onGiftThemesSelectedChange = (e) => {
        resetErrors('giftThemesError');
        const { target: { value } } = e;
        setGiftThemesSelected(typeof value === 'string' ? value.split(',') : value);
    };
    const onBudgetChange = (e) => {
        resetErrors('budgetError');
        setBudget(e.target.value);
    }
    const onGenderRevielChange = (e) => setGenderReviel(e.target.value);

    const handleCreateRoom = () => {
        validateForm();
        const newRoomData = {
            roomName: roomName,
            roomPassCode: roomPass,
            codeNamesTheme: codeNamesThemeSelected,
            giftTheme: giftThemesSelected,
            budget: budget,
            genderReviel: genderReviel
        }
        //todo send to BE
        if(!validationErrors){
        createRoom(newRoomData)
            .then(res => {
                if(res.status === 200) {
                    const roomId = res.data;
                    navigate('room',  { replace: false,  state: { roomId: roomId } });
                }
            });
        }
    }

    useEffect(() => {
        getNicknameThemes()
        .then(data => setCodeNamesThemes(data));
        getGiftThemes()
        .then(data => setGiftThemes(data));
    }, []);

    return (
      <div>
        <Modal
          aria-labelledby="transition-modal-title"
          aria-describedby="transition-modal-description"
          open={open}
          onClose={() => {
            onClose();
            setGiftThemesSelected([]);
            setCodeNamesThemeSelected('');
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

                        <FancySelect 
                            label="Code Names Theme"
                            source={codeNamesThemes}
                            handleChange={onCodeNamesThemeSelectedChange}
                            value={codeNamesThemeSelected}
                            error={validationErrors?.codeNamesThemeError}
                        />
                        <MultipleSelect 
                            label="Code Gift Theme"
                            source={giftThemes}
                            handleChange={onGiftThemesSelectedChange}
                            value={giftThemesSelected}
                            error={validationErrors?.giftThemesError}
                        />

                        <TextField 
                            id="standard-basic" 
                            label="Budget" 
                            variant="standard" 
                            onChange={onBudgetChange}
                            error={validationErrors?.budgetError}
                        />
                        <FormControlLabel 
                            control={<Checkbox defaultChecked />} 
                            label="I want to know the gender" 
                            onChange={onGenderRevielChange}
                        />

                        <Button 
                            variant="outlined"
                            onClick={handleCreateRoom}>
                                create room
                            </Button>
                        {/* </FormGroup> */}
                </Stack>
            </Box>
          </Fade>
        </Modal>
      </div>
    );
  }

  export default CreateRoomModal;