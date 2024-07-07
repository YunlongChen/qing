export interface MenuItem {
    id: number;
    menuId: string;
    parentId: number;
    menuName: string;
    parentName: string;
    path: string;
    component: string;
    menuType: string;
    visible: boolean;
    status: string;
    icon: string;
    children: MenuItem[];
}
