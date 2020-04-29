function toggleDropdown() {
    $('#dropdown').toggleClass("open");
}
  
$(document).ready(function () {
    $('#dropdown-button').click(function () {
        toggleDropdown();
    });
});