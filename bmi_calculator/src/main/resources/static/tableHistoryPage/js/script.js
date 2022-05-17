
function textColors() {
    var results = document.querySelectorAll('.imc');

    results.forEach(element => {
        var imc = parseFloat(element.innerHTML);

        if(imc < 18.5) {
            // document.documentElement.style.setProperty('--grau-color', '#01C5E0');
            element.style.color = '#01C5E0';
        }
        else if(imc > 18.5 && imc < 25) {
            element.style.color = '#01CD15';
        }
        else if(imc > 24.9 && imc < 30) {
            element.style.color = '#CDA001';
        }
        else if(imc > 29.9 && imc < 35) {
            element.style.color = '#EC7F00';
        }
        else if(imc > 34.9 && imc < 40) {
            element.style.color = '#EC5500';
        }
        else if(imc > 39.9) {
            element.style.color = '#EC0E00';
        }
    })

}

