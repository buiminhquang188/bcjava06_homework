$(document).ready(function () {
    const preloader = $(".preloader");
    const observerOptions = {
        attributes: true,
        attributeFilter: ["style"]
    };

    const observer = new MutationObserver(callbackMutation);
    observer.observe(preloader[0], observerOptions);
})

function callbackMutation(records, observer) {
    for (const record of records) {
        const activeEle = $(".waves-effect.active")[0]
        if (!activeEle && !activeEle.classList.contains("active")) return;
        observer.disconnect();
        activeEle.classList.remove("active");
        break;
    }
}