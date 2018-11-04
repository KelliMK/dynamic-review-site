const button = document.querySelector('button')


const inputBox = document.querySelector('inputBox')



button.addEventListener('click', addTagToReview)

function addTagToReview() {
	var xhttp = new XMLHttpRequest()
	xhttp.addEventListener('readystatechange', function(){
		if(isReady(xhttp)){
			const sidebar = document.querySelector('aside')
			sidebar.innerHTML = this.response
		}
	})
}