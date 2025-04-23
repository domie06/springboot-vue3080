const base = {
    get() {
        return {
            url : "http://localhost:8080/lvkexingliguanlixitong/",
            name: "lvkexingliguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lvkexingliguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "旅客行李管理系统"
        } 
    }
}
export default base
