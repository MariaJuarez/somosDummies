import React from 'react';
import DayPickerInput from 'react-day-picker/DayPickerInput';
import 'react-day-picker/lib/style.css';
import 'moment/locale/es';
import MomentLocaleUtils from 'react-day-picker/moment';


export default function Example() {
  return (
    <div>
      <p>Please type a day:</p>
      
      <DayPickerInput placeholder="DD/MM/YYYY"  dayPickerProps={{ format: 'DD-MM-YYYY' ,localeUtils: MomentLocaleUtils, locale:"es"}} />
    </div>
  )
}