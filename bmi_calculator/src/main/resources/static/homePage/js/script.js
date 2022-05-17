const btnCalculate = document.querySelector('.calculateButton')
const popup = document.querySelector('.popupWrapper')
const xClose = document.querySelector('.popupClose')
const btnCalculateAgain = document.querySelector('.calculateAgainButton')
const txtWeight = document.querySelector('.weight');
const txtHeight = document.querySelector('.height');

// when pressing the Calculate Button, Verify if the textBoxs Weight and Height
// Are filled, if yes, performs BMI calculation
btnCalculate.addEventListener('click', function () {
    var textBox = document.querySelectorAll('.textBox');
    var weightField = parseFloat(textBox[0].value);
    var heightField = parseFloat(textBox[1].value);
    
    if(!isNaN(weightField) && !isNaN(heightField)) {

        var imc = (weightField / (heightField ** 2)).toFixed(2);
        var imcResult = document.querySelector('.imcResult');
        imcResult.innerHTML = imc;

        // Post the result to the API
        const URL = 'http://localhost:8080/api/bmi'
        var xhr = new XMLHttpRequest();
        xhr.open("POST", URL, true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send(JSON.stringify({
            weight: weightField,
            height: heightField,
            bmiPerformance: imc
        }));

        // End Post // 

        // Sets the color according to the BMI degree
        if(imc < 18.5) {
            var imcGrauResult = document.querySelector('.imcGrauResult');
            imcGrauResult.innerHTML = 'Magro';

            document.documentElement.style.setProperty('--grau-color', '#01C5E0');
        }
        else if(imc > 18.5 && imc < 25) {
            var imcGrauResult = document.querySelector('.imcGrauResult');
            imcGrauResult.innerHTML = 'Peso Ideal';

            document.documentElement.style.setProperty('--grau-color', '#01CD15')
        }
        else if(imc > 24.9 && imc < 30) {
            var imcGrauResult = document.querySelector('.imcGrauResult');
            imcGrauResult.innerHTML = 'Levemente Acima do Peso';

            document.documentElement.style.setProperty('--grau-color', '#CDA001')
        }
        else if(imc > 29.9 && imc < 35) {
            var imcGrauResult = document.querySelector('.imcGrauResult');
            imcGrauResult.innerHTML = 'Obesidade - I';

            document.documentElement.style.setProperty('--grau-color', '#EC7F00')
        }
        else if(imc > 34.9 && imc < 40) {
            var imcGrauResult = document.querySelector('.imcGrauResult');
            imcGrauResult.innerHTML = 'Obesidade - II (Severa)';

            document.documentElement.style.setProperty('--grau-color', '#EC5500')
        }
        else if(imc > 39.9) {
            var imcGrauResult = document.querySelector('.imcGrauResult');
            imcGrauResult.innerHTML = 'Obesidade - III (Mórbida)';

            document.documentElement.style.setProperty('--grau-color', '#EC0E00')
        }

        popup.style.display = 'block'
    } 
    // If any field is not filled, change the color of the border indicating to be filled
    else {
        if(isNaN(weightField)) {
            var input = document.querySelector('.weight');
            input.style.border = '1.5px solid rgba(200, 0, 0, 0.8)'
        }
        if(isNaN(heightField)) {
            var input = document.querySelector('.height');
            input.style.border = '1.5px solid rgba(200, 0, 0, 0.8)'
        }
    }
})

// if the close popup button is pressed, close the popup
xClose.addEventListener('click', function () {
    reset();
})

// if pressed outside the popup, it also closes the popup
popup.addEventListener('click', function(e) {

    if(e.target == this) {
        reset();
    }
})

// close the popup to calculate BMI again
btnCalculateAgain.addEventListener('click', function () {
    reset();
})

// if the textBox border is red (error warning) and pressed any key, change the border to 0
txtWeight.addEventListener('keydown', function () {
    if(this.style.border === '1.5px solid rgba(200, 0, 0, 0.8)') {
        this.style.border = '0';
    }
})
txtHeight.addEventListener('keydown', function () {
    if(this.style.border === '1.5px solid rgba(200, 0, 0, 0.8)') {
        this.style.border = '0';
    }
})

// Functions 

function reset() {
    popup.style.display = 'none';
    var textBox = document.querySelectorAll('input[type=number]');
    textBox.forEach(element => {
        element.value = null;
    });
}

// Fix the border red bug when the textBox is focused and before the null field error occurred
window.onload = function () {
    var fields = document.querySelectorAll('.textBox');

    fields.forEach(element => {
        element.addEventListener('click', 
        function () {
            if(this.style.border === '1.5px solid rgba(200, 0, 0, 0.8)') {
                this.style.border = '0';
            }
        })
    });
}

// Re