export const createLanguageData = (language_data) => {
    debugger
    return $.ajax({
        method: 'post',
        url: `/api/language_data/`,
        data: {language_data}
    })
}

export const updateLanguageData = (language_data)=> {
    
    return $.ajax({
        method: 'patch',
        url: `api/language_data/${language_data.id}`,
        data: {language_data}
    })
}