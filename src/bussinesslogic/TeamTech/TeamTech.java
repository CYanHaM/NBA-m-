package bussinesslogic.TeamTech;

import java.util.ArrayList;
import java.util.Comparator;

import PO.TeamTechPO;
import TypeEnum.SortEnum;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import blservice.teamtechblservice.TeamTechBLService;
import bussinesslogic.Transfer.L2V.TeamTechL2V;
import bussinesslogic.Transfer.P2L.TeamTechP2L;
import data.TeamTechData;
import dataservice.TeamTechDataService;

public class TeamTech {
	TeamTechDataService ttds = new TeamTechData();
	
	public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType, boolean high, int number) {
		// TODO Auto-generated method stub
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();
		if(DataType.equals(TeamTechEnum.name)){
			ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();
			for(int i = 0; i<30; i++){
				TeamTechP2L p2l = new TeamTechP2L();
				TeamTechL2V l2v = new TeamTechL2V();
				result.add(l2v.l2v(p2l.p2l(list.get(i))));
			}
			return result;
		}
		
		ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
		for(int i = 0; i<30; i++){
			TeamTechP2L p2l = new TeamTechP2L();
			forSort.add(p2l.p2l(list.get(i)));
		}
		
		Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
			public int compare(TeamTechLineItem t1, TeamTechLineItem t2){
				switch(DataType){
				case score:
					if(t1.score==t2.score){
						if(t1.rebound==t2.rebound){
							if(t1.secondaryAttack==t2.secondaryAttack){
								if(t1.blockShot==t2.blockShot){
									if(t1.steal==t2.steal){
										if(t1.foul==t2.foul){
											if(t1.fault==t2.fault){
												if(t1.shotInRate==t2.shotInRate){
													if(t1.threeShotInRate==t2.threeShotInRate){
														if(t1.penaltyShotInRate==t2.penaltyShotInRate){
															if(t1.defensiveRebound==t2.defensiveRebound){
																if(t1.offensiveRebound==t2.offensiveRebound){
																	return 0;
																}
																return t1.offensiveRebound-t2.offensiveRebound;
															}
															return t1.defensiveRebound-t2.defensiveRebound;
														}
														return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
													}
													return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
												}
												return (t1.shotInRate-t2.shotInRate)>0?1:-1;
											}
											return t1.fault-t2.fault;
										}
										return t1.foul-t2.foul;
									}
									return t1.steal-t2.steal;
								}
								return t1.blockShot-t2.blockShot;
							}
							return t1.secondaryAttack-t2.secondaryAttack;
						}
						return t1.rebound-t2.rebound;
					}
					return t1.score-t2.score;
					;
				case rebound:
					if(t1.rebound==t2.rebound){
						if(t1.secondaryAttack==t2.secondaryAttack){
							if(t1.blockShot==t2.blockShot){
								if(t1.steal==t2.steal){
									if(t1.foul==t2.foul){
										if(t1.fault==t2.fault){
											if(t1.shotInRate==t2.shotInRate){
												if(t1.threeShotInRate==t2.threeShotInRate){
													if(t1.penaltyShotInRate==t2.penaltyShotInRate){
														if(t1.defensiveRebound==t2.defensiveRebound){
															if(t1.offensiveRebound==t2.offensiveRebound){
																return 0;
															}
															return t1.offensiveRebound-t2.offensiveRebound;
														}
														return t1.defensiveRebound-t2.defensiveRebound;
													}
													return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
												}
												return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
											}
											return (t1.shotInRate-t2.shotInRate)>0?1:-1;
										}
										return t1.fault-t2.fault;
									}
									return t1.foul-t2.foul;
								}
								return t1.steal-t2.steal;
							}
							return t1.blockShot-t2.blockShot;
						}
						return t1.secondaryAttack-t2.secondaryAttack;
					}
					return t1.rebound-t2.rebound;
					;
				case secondaryAttack:
					if(t1.secondaryAttack==t2.secondaryAttack){
						if(t1.blockShot==t2.blockShot){
							if(t1.steal==t2.steal){
								if(t1.foul==t2.foul){
									if(t1.fault==t2.fault){
										if(t1.shotInRate==t2.shotInRate){
											if(t1.threeShotInRate==t2.threeShotInRate){
												if(t1.penaltyShotInRate==t2.penaltyShotInRate){
													if(t1.defensiveRebound==t2.defensiveRebound){
														if(t1.offensiveRebound==t2.offensiveRebound){
															return 0;
														}
														return t1.offensiveRebound-t2.offensiveRebound;
													}
													return t1.defensiveRebound-t2.defensiveRebound;
												}
												return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
											}
											return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
										}
										return (t1.shotInRate-t2.shotInRate)>0?1:-1;
									}
									return t1.fault-t2.fault;
								}
								return t1.foul-t2.foul;
							}
							return t1.steal-t2.steal;
						}
						return t1.blockShot-t2.blockShot;
					}
					return t1.secondaryAttack-t2.secondaryAttack;
					;
				case blockShot:
					if(t1.blockShot==t2.blockShot){
						if(t1.steal==t2.steal){
							if(t1.foul==t2.foul){
								if(t1.fault==t2.fault){
									if(t1.shotInRate==t2.shotInRate){
										if(t1.threeShotInRate==t2.threeShotInRate){
											if(t1.penaltyShotInRate==t2.penaltyShotInRate){
												if(t1.defensiveRebound==t2.defensiveRebound){
													if(t1.offensiveRebound==t2.offensiveRebound){
														return 0;
													}
													return t1.offensiveRebound-t2.offensiveRebound;
												}
												return t1.defensiveRebound-t2.defensiveRebound;
											}
											return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
										}
										return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
									}
									return (t1.shotInRate-t2.shotInRate)>0?1:-1;
								}
								return t1.fault-t2.fault;
							}
							return t1.foul-t2.foul;
						}
						return t1.steal-t2.steal;
					}
					return t1.blockShot-t2.blockShot;
					;
				case steal:
					if(t1.steal==t2.steal){
						if(t1.foul==t2.foul){
							if(t1.fault==t2.fault){
								if(t1.shotInRate==t2.shotInRate){
									if(t1.threeShotInRate==t2.threeShotInRate){
										if(t1.penaltyShotInRate==t2.penaltyShotInRate){
											if(t1.defensiveRebound==t2.defensiveRebound){
												if(t1.offensiveRebound==t2.offensiveRebound){
													return 0;
												}
												return t1.offensiveRebound-t2.offensiveRebound;
											}
											return t1.defensiveRebound-t2.defensiveRebound;
										}
										return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
									}
									return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
								}
								return (t1.shotInRate-t2.shotInRate)>0?1:-1;
							}
							return t1.fault-t2.fault;
						}
						return t1.foul-t2.foul;
					}
					return t1.steal-t2.steal;
					;
				case foul:
					if(t1.foul==t2.foul){
						if(t1.fault==t2.fault){
							if(t1.shotInRate==t2.shotInRate){
								if(t1.threeShotInRate==t2.threeShotInRate){
									if(t1.penaltyShotInRate==t2.penaltyShotInRate){
										if(t1.defensiveRebound==t2.defensiveRebound){
											if(t1.offensiveRebound==t2.offensiveRebound){
												return 0;
											}
											return t1.offensiveRebound-t2.offensiveRebound;
										}
										return t1.defensiveRebound-t2.defensiveRebound;
									}
									return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
								}
								return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
							}
							return (t1.shotInRate-t2.shotInRate)>0?1:-1;
						}
						return t1.fault-t2.fault;
					}
					return t1.foul-t2.foul;
					;
				case fault:
					if(t1.fault==t2.fault){
						if(t1.shotInRate==t2.shotInRate){
							if(t1.threeShotInRate==t2.threeShotInRate){
								if(t1.penaltyShotInRate==t2.penaltyShotInRate){
									if(t1.defensiveRebound==t2.defensiveRebound){
										if(t1.offensiveRebound==t2.offensiveRebound){
											return 0;
										}
										return t1.offensiveRebound-t2.offensiveRebound;
									}
									return t1.defensiveRebound-t2.defensiveRebound;
								}
								return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
							}
							return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
						}
						return (t1.shotInRate-t2.shotInRate)>0?1:-1;
					}
					return t1.fault-t2.fault;
					;
				case shotInRate:
					if(t1.shotInRate==t2.shotInRate){
						if(t1.threeShotInRate==t2.threeShotInRate){
							if(t1.penaltyShotInRate==t2.penaltyShotInRate){
								if(t1.defensiveRebound==t2.defensiveRebound){
									if(t1.offensiveRebound==t2.offensiveRebound){
										return 0;
									}
									return t1.offensiveRebound-t2.offensiveRebound;
								}
								return t1.defensiveRebound-t2.defensiveRebound;
							}
							return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
						}
						return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
					}
					return (t1.shotInRate-t2.shotInRate)>0?1:-1;
					;
				case threeShotInRate:
					if(t1.threeShotInRate==t2.threeShotInRate){
						if(t1.penaltyShotInRate==t2.penaltyShotInRate){
							if(t1.defensiveRebound==t2.defensiveRebound){
								if(t1.offensiveRebound==t2.offensiveRebound){
									return 0;
								}
								return t1.offensiveRebound-t2.offensiveRebound;
							}
							return t1.defensiveRebound-t2.defensiveRebound;
						}
						return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
					}
					return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
					;
				case penaltyShotInRate:
					if(t1.penaltyShotInRate==t2.penaltyShotInRate){
						if(t1.defensiveRebound==t2.defensiveRebound){
							if(t1.offensiveRebound==t2.offensiveRebound){
								return 0;
							}
							return t1.offensiveRebound-t2.offensiveRebound;
						}
						return t1.defensiveRebound-t2.defensiveRebound;
					}
					return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
					;
				case defensiveRebound:
					if(t1.defensiveRebound==t2.defensiveRebound){
						if(t1.offensiveRebound==t2.offensiveRebound){
							return 0;
						}
						return t1.offensiveRebound-t2.offensiveRebound;
					}
					return t1.defensiveRebound-t2.defensiveRebound;
					;
				case offensiveRebound:
					return t1.offensiveRebound-t2.offensiveRebound;
					;
				//
				case winningRate:;
				case offensiveRound:;
				case offensiveEfficiency:;
				case defensiveEfficiency:;
				case offendReboundEfficiency:;
				case deffendReboundEfficiency:;
				case stealEfficiency:;
				case secondaryAttackEfficiency:;
				}
			}
		};
		return null;
	}

	public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType, boolean high, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TeamTechVO> refresh(SortEnum sort, TeamTechEnum DataType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TeamTechVO> findSeasonHotTeam(TeamTechEnum DataType, int number) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	
}
