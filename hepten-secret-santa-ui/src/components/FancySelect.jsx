import React, { useState } from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

const FancySelect = ({ label, source, value, handleChange }) => {
//   const [value, setValue] = useState('');

//   const handleChange = (event) => {
//     setValue(event.target.value);

//   };

  return (
    <div>
      <FormControl variant="standard" sx={{ minWidth: 300 }}>
        <InputLabel id="demo-simple-select-standard-label">{label}</InputLabel>
        <Select
          labelId="demo-simple-select-standard-label"
          id="select-standard"
          value={value}
          onChange={handleChange}
          label={label}
        >
            {source.map((name) => (
            <MenuItem
              key={name}
              value={name}
            //   style={getStyles(name, personName, theme)}
            >
              {name}
            </MenuItem>
          ))}
        
        </Select>
      </FormControl>
      
    </div>
  );
}

export default FancySelect;